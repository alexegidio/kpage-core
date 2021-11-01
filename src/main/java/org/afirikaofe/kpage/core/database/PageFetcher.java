package org.afirikaofe.kpage.core.database;

import org.afirikaofe.kpage.core.model.Page;

public interface PageFetcher {

    Page fetchPageFromDb(String taskName);
}
