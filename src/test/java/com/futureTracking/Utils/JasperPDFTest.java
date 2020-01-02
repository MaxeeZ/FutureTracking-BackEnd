/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futureTracking.Utils;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.core.io.ByteArrayResource;

/**
 *
 * @author maxim
 */
public class JasperPDFTest {

    public JasperPDFTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ExportPDF method, of class JasperPDF.
     */
    @Test
    public void testExportPDF() {
        System.out.println("ExportPDF");
        String JsonObject = "{\n"
                + "    \"id\": 1,\n"
                + "    \"name\": \"Jeanne\\u0027s timpani\",\n"
                + "    \"category\": 0,\n"
                + "    \"description\": \"\",\n"
                + "    \"ingredients\": \"4 slices of smokeds salmon, 2 zucchini, 3 eggs, 10 cl thick fresh cream, 1 small garlic clove, 1 tablespoon olive oil, dill mint, salt, pepper\",\n"
                + "    \"person\": 4,\n"
                + "    \"duration\": 18,\n"
                + "    \"level\": 1,\n"
                + "    \"url\": \"https://assets.afcdn.com/recipe/20140921/15292_w800h600c1cx1224cy1224.jpg\"\n"
                + "}";
        JasperPDF.ExportPDF(JsonObject);
        
        assertEquals(true, true);
    }

    /**
     * Test of downloadReport method, of class JasperPDF.
     * @throws java.lang.Exception
     */
    @Test
    public void testDownloadReport() throws Exception {
        System.out.println("downloadReport");
        ByteArrayResource result = JasperPDF.downloadReport();
        boolean actualResult = (result.contentLength()!= 0);
        
        assertEquals(true, actualResult);
    }

}
