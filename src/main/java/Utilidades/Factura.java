/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 *
 * @author andre
 */
public class Factura {
     public void generarFactura(String nombrePropietario, String valorAdministracion, String fecha, String idPropietario, String numeroCasa) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("factura.pdf"));
            document.open();
            
            // Título
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("Factura - Conjunto Residencial Hojas Secas", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            document.add(new Paragraph(" "));
            
            // Tabla
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            
            PdfPCell cell;
            
            cell = new PdfPCell(new Paragraph("Nombre del Propietario"));
            table.addCell(cell);
            table.addCell(nombrePropietario);
            
            cell = new PdfPCell(new Paragraph("Valor de Administración"));
            table.addCell(cell);
            table.addCell(valorAdministracion);
            
            cell = new PdfPCell(new Paragraph("Fecha"));
            table.addCell(cell);
            table.addCell(fecha);
            
            cell = new PdfPCell(new Paragraph("ID del Propietario"));
            table.addCell(cell);
            table.addCell(idPropietario);
            
            cell = new PdfPCell(new Paragraph("Número de Casa"));
            table.addCell(cell);
            table.addCell(numeroCasa);
            
            document.add(table);
            
            // Elementos adicionales
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Gracias por su pago a tiempo."));
            
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
