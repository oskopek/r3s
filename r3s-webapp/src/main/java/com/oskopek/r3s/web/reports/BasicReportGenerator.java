/*
 * Copyright 2015 R3S Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.oskopek.r3s.web.reports;

import com.oskopek.r3s.core.model.DefaultRegistration;
import com.oskopek.r3s.core.model.Runner;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

/**
 * Provides functionality for filling and exporting a report.
 */
public class BasicReportGenerator {

    private JasperPrint filledReportPrint;

    /**
     * Constructs a basic report from the parameters.
     *
     * @param e                     the FileEntry from which to fill the data
     * @param templateFilename      the template report to fill
     * @param reportBuilderLocation the place where report is being built (physical, real)
     * @param reportName            the title of the report
     * @param hostURL               URL of the domain that is generating the report
     * @param tz                    TimeZone of the returned date (it is stored in UTC)
     * @throws JRException if an error during the generation occurs
     */
    public BasicReportGenerator(DefaultRegistration e, String templateFilename, String reportBuilderLocation,
                                String reportName, String hostURL, TimeZone tz) throws JRException {

        Map<String, Object> values = new HashMap<>();
        Map<String, Object> parameters = new HashMap<>();

        Runner runner = e.getRunner();

        Long entryId = e.getId() == null ? 0 : e.getId();
        String reportId = entryId + "-" + System.currentTimeMillis();

        // TimeZone:

        DateFormat dateFormat = new SimpleDateFormat("dd. MM. yyyy");
        dateFormat.setTimeZone(tz);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setTimeZone(tz);

        // report
        parameters.put("reportid", reportId);
        parameters.put("reportname", reportName);
        parameters.put("reportlocation", reportBuilderLocation);
        parameters.put("reportdate", dateFormat.format(new Date(System.currentTimeMillis())));

        // data

        /*
        Address add = runner.getAddress();
        String dataLocation = add.print();

        // parameters.put("id", Long.toString(data.getId()));

        Path imagePath = e.getCarImages().get(0).getFilepath().toAbsolutePath();

        if (Files.exists(imagePath) && Files.isRegularFile(imagePath)) {
            parameters.put("previewURL", imagePath.toString());
        } else {
            parameters.put("previewURL", "/reports/OpenCV_Logo_with_text.png");
        }

        parameters.put("date", dateFormat.format(runner.getTimestamp()));
        parameters.put("location", dataLocation);
        parameters.put("LPNumber", runner.getNumberPlate().getText());
        parameters.put("videoURL", hostURL + "/servlet/GenerateVideo?entry_id=" + e.getId().toString());
        parameters.put("time", timeFormat.format(runner.getTimestamp()));
        parameters.put("speed", Double.toString(runner.getSpeed().getSpeed()) + " "
                + runner.getSpeed().getUnit().toString());
        */

        // parameters.put

        Collection<Map<String, ?>> mapList = new ArrayList<>();
        mapList.add(values);

        JRMapCollectionDataSource mapDataSource = new JRMapCollectionDataSource(mapList);

        // compile template - already precompiled
        // JasperCompileManager.compileReportToFile(templateFilename + ".jrxml",
        // templateFilename + ".jasper");

        // fill with data
        InputStream templateInputStream = getClass().getResourceAsStream(templateFilename);

        filledReportPrint = JasperFillManager.fillReport(templateInputStream, parameters, mapDataSource);

    }

    /**
     * Exports the report to a file in PDF format.
     *
     * @param filename file path of the exported report
     * @throws JRException if an error during exporting occurs
     */
    public void exportFile(String filename) throws JRException {
        JRExporter exporter = new JRPdfExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, filledReportPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, filename);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");

        exporter.exportReport();
    }

    /**
     * Writes the report into the OutputStream in PDF format.
     *
     * @param filename filename of the exported report
     * @throws JRException if an error during exporting occurs
     */
    public void exportStream(String filename, OutputStream out) throws JRException {
        JRExporter exporter = new JRPdfExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, filledReportPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, filename);
        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

        exporter.exportReport();
    }
}