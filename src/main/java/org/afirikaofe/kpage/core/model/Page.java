package org.afirikaofe.kpage.core.model;

public class Page {

    private int firstPage;

    private int finalPage;

    public Page(int firstPage, int finalPage) {
        this.firstPage = firstPage;
        this.finalPage = finalPage;
    }

    public Page() {
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getFinalPage() {
        return finalPage;
    }

    public void setFinalPage(int finalPage) {
        this.finalPage = finalPage;
    }
}
