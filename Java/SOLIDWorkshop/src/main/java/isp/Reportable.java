package isp;

import java.io.BufferedReader;

public interface Reportable {
    public byte[] generateExcel(BufferedReader reader);
    public byte[] generatePdf(BufferedReader reader);
}
