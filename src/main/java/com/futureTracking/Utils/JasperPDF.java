package com.futureTracking.Utils;
        
import java.util.Map;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JsonDataSource;
import static org.hibernate.internal.util.ConfigHelper.getResourceAsStream;
import org.springframework.core.io.ByteArrayResource;

public class JasperPDF {

    public static void ExportPDF(String JsonObject) {
        try {
            try {
                InputStream recipeReportStream;
                recipeReportStream = getResourceAsStream("/jasperReportFormat.jrxml");
                JasperReport jasperReport = JasperCompileManager.compileReport(recipeReportStream);
                
                //Convert json string to byte array.
                ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(JsonObject.getBytes());
                
                //Create json datasource from json stream
                JsonDataSource ds = new JsonDataSource(jsonDataStream);
                
                //Create HashMap to add report parameters
                Map parameters = new HashMap();
                
                //Add title parameter. Make sure the key is same name as what you named the parameter in jasper report.
                parameters.put("title", "ReportRecipeJasperPDF");
                
                //Create Jasper Print object passing report, parameter json data source.
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
                
                //Export and save pdf to file
                JasperExportManager.exportReportToPdfFile(jasperPrint, System.getProperty("java.io.tmpdir") + "/ReportRecipeJasperPDF");

            } catch (JRException ex) {
                throw new RuntimeException(ex);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static ByteArrayResource downloadReport() throws IOException {
        
        File file = new File(System.getProperty("java.io.tmpdir") + "/ReportRecipeJasperPDF");
        Path path = Paths.get(file.getAbsolutePath());
        
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        
        return resource;
    }
    
}
