package com.ec.lidl.generators;

import net.sf.jasperreports.engine.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class PdfStreamingOutput implements StreamingOutput {

    private Map<String, Object> data;
    private InputStream templateIS;

    public PdfStreamingOutput(Map<String, Object> data, InputStream templateIS) {
        this.data = data;
        this.templateIS = templateIS;
    }

    @Override
    public void write(OutputStream outputStream) throws WebApplicationException {
        try{
            JasperReport report = JasperCompileManager.compileReport(templateIS);
            JRDataSource dataSource = new JREmptyDataSource();
            JasperPrint print = JasperFillManager.fillReport(report, data, dataSource);
            JasperExportManager.exportReportToPdfStream(print, outputStream);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
