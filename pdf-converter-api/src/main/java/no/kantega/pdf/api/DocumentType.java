package no.kantega.pdf.api;

import java.io.Serializable;

public class DocumentType implements Serializable, Comparable<DocumentType> {

    public static final DocumentType MS_WORD = new DocumentType(Value.APPLICATION, Value.WORD_ANY);
    public static final DocumentType RTF = new DocumentType(Value.APPLICATION, Value.RTF);
    public static final DocumentType DOCX = new DocumentType(Value.APPLICATION, Value.DOCX);
    public static final DocumentType DOC = new DocumentType(Value.APPLICATION, Value.DOC);
    public static final DocumentType MS_EXCEL = new DocumentType(Value.APPLICATION, Value.EXCEL_ANY);
    public static final DocumentType XLSX = new DocumentType(Value.APPLICATION, Value.XLSX);
    public static final DocumentType XLS = new DocumentType(Value.APPLICATION, Value.XLS);
    public static final DocumentType ODS = new DocumentType(Value.APPLICATION, Value.ODS);
    public static final DocumentType CSV = new DocumentType(Value.TEXT, Value.CSV);
    public static final DocumentType XML = new DocumentType(Value.APPLICATION, Value.XML);
    public static final DocumentType MHTML = new DocumentType(Value.APPLICATION, Value.MHTML);
    public static final DocumentType PDF = new DocumentType(Value.APPLICATION, Value.PDF);
    public static final DocumentType PDFA = new DocumentType(Value.APPLICATION, Value.PDFA);
    public static final DocumentType TEXT = new DocumentType(Value.TEXT, Value.PLAIN);

    private final String type;
    private final String subtype;

    public DocumentType(String type, String subtype) {
        if (type == null || subtype == null) {
            throw new NullPointerException("Type elements must not be null");
        }
        this.type = type;
        this.subtype = subtype;
    }

    public DocumentType(String inputType) {
        int separator = inputType.indexOf('/');
        if (separator == -1 || inputType.length() == separator + 1) {
            throw new IllegalArgumentException("Not a legal */* document type: " + inputType);
        } else {
            type = inputType.substring(0, separator);
            subtype = inputType.substring(separator + 1);
        }
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DocumentType documentType = (DocumentType) other;
        return subtype.equals(documentType.subtype) && type.equals(documentType.type);
    }

    @Override
    public int hashCode() {
        return 31 * type.hashCode() + subtype.hashCode();
    }

    @Override
    public int compareTo(DocumentType other) {
        return toString().compareTo(other.toString());
    }

    @Override
    public String toString() {
        return type + "/" + subtype;
    }

    public static class Value {

        public static final String APPLICATION = "application";
        public static final String TEXT = "text";

        public static final String DOC = "msword";
        public static final String DOCX = "vnd.openxmlformats-officedocument.wordprocessingml.document";
        public static final String WORD_ANY = "vnd.no.kantega.pdf.any-msword";

        public static final String XLS = "vnd.ms-excel";
        public static final String XLSX = "vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        public static final String EXCEL_ANY = "vnd.no.kantega.pdf.any-msexcel";
        public static final String ODS = "vnd.oasis.opendocument.spreadsheet";

        public static final String PDF = "pdf";
        public static final String PDFA = "vnd.no.kantega.pdf.pdf-a";

        public static final String RTF = "rtf";

        public static final String XML = "xml";
        public static final String MHTML = "x-mimearchive";

        public static final String CSV = "csv";
        public static final String PLAIN = "plain";

        private Value() {
            throw new UnsupportedOperationException();
        }
    }
}
