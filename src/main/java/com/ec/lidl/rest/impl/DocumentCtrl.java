package com.ec.lidl.rest.impl;

import com.ec.lidl.beans.DetailsBean;
import com.ec.lidl.beans.LineBean;
import com.ec.lidl.generators.PdfStreamingOutput;
import com.ec.lidl.rest.IDocumentController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

public class DocumentCtrl implements IDocumentController {

    @Override
    public Response generateDocumentAndReturn(DetailsBean detailsBean) throws IOException {
        InputStream templateIS = new ClassPathResource("invoice_pfa.jrxml").getInputStream();


        Map<String, Object> map = new HashMap<>();

        map.put("supplier_name", detailsBean.getSupplier().getName());
        map.put("supplier_address", detailsBean.getSupplier().getAddress());
        map.put("supplier_vat", detailsBean.getSupplier().getCif());
        map.put("supp_reg_com", detailsBean.getSupplier().getRegCom());
        map.put("supplier_bank", detailsBean.getSupplier().getBank());
        map.put("supplier_bank_account", detailsBean.getSupplier().getAccount());

        map.put("buyer_name", detailsBean.getBuyer().getName());
        map.put("buyer_j", detailsBean.getBuyer().getRegCom());
        map.put("buyer_cui", detailsBean.getBuyer().getCif());
        map.put("buyer_bank", detailsBean.getBuyer().getBank());
        map.put("buyer_account", detailsBean.getBuyer().getAccount());
        map.put("buyer_address", detailsBean.getBuyer().getAddress());

        map.put("invoice_number", detailsBean.getInvoice_number());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = format.format(detailsBean.getInvoice_date());

        Calendar c = Calendar.getInstance();
        c.setTime(detailsBean.getInvoice_date());
        c.add(Calendar.DATE, 7);
        Date due_date = c.getTime();
        String due_date_string = format.format(due_date);

        map.put("invoice_date", dateString);
        map.put("invoice_due_date", due_date_string);

        map.put("invoice_series", detailsBean.getInvoice_series());
        map.put("total_price", detailsBean.getInvoice_total_amount() + ".00");
        map.put("observations", detailsBean.getObservations());

        Collection<Map<String, Object>>lines = new ArrayList<>();

        int index = 1;
        for(LineBean lineBean: detailsBean.getLines()){
            Map<String, Object> line = new HashMap<>();
            line.put("item_no", index + "");
            line.put("item_desc", lineBean.getName());
            line.put("item_qty", lineBean.getQty());
            line.put("item_price", lineBean.getPrice() + ".00");
            lines.add(line);
            index++;
        }

        map.put("invoiceLines", lines);

        String contentDisposition = "attachment; filename=\"document.pdf\"";
        return Response.ok(new PdfStreamingOutput(map, templateIS)).header("Content-Disposition", contentDisposition).build();
    }
}
