package org.afirikaofe.kpage;

import org.afirikaofe.kpage.core.database.PageFetcher;
import org.afirikaofe.kpage.core.database.DataBasePageFetcher;
import org.afirikaofe.kpage.core.model.Page;

public class Pagination {

    private final PageFetcher pageFetcher;

    public Pagination() {
        pageFetcher = new DataBasePageFetcher();
    }

    public Pagination(PageFetcher pageFetcher) {
        this.pageFetcher = pageFetcher;
    }

    public Page retrievePage(String taskName, int pageSize) {
        Page page = pageFetcher.fetchPageFromDb(taskName);
        page.setFinalPage(page.getFirstPage() + pageSize);
        return page;
    }
}
