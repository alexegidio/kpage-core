package org.afirikaofe.kpage;

import org.afirikaofe.kpage.core.database.Configuration;
import org.afirikaofe.kpage.core.database.PageFetcher;
import org.afirikaofe.kpage.core.database.DataBasePageFetcher;
import org.afirikaofe.kpage.core.model.Page;
import org.afirikaofe.kpage.infrastructure.PropertiesLoader;

import java.util.Properties;

public class Pagination {

    private final PageFetcher pageFetcher;

    public Pagination() {
        pageFetcher = new DataBasePageFetcher();
        initConfiguration();
    }

    public Pagination(PageFetcher pageFetcher) {
        this.pageFetcher = pageFetcher;
    }

    public Page retrievePage(String taskName, int pageSize) {
        Page page = pageFetcher.fetchPageFromDb(taskName);
        page.setFinalPage(page.getFirstPage() + pageSize);
        return page;
    }


    private void initConfiguration() {
        Configuration.getInstance().setDbName(PropertiesLoader.getInstance().getProperty(""));
    }

}
