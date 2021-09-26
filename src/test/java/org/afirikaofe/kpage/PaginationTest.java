package org.afirikaofe.kpage;

import org.afirikaofe.kpage.core.database.PageFetcher;
import org.afirikaofe.kpage.core.model.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class PaginationTest {

    private Pagination pagination;

    private PageFetcher pageFetcher = Mockito.mock(PageFetcher.class);

    @BeforeEach
    void setUp() {
        pagination = new Pagination(pageFetcher);
    }

    @Test
    void retrievePageForNewTaskShouldReturnPageInitial0ToPageSize() {
        int pageSize = 100;
        String taskName = "foo";
        when(pageFetcher.fetchPageFromDb(taskName)).thenReturn(new Page(0,0));
        Page page = pagination.retrievePage(taskName, pageSize);

        Assertions.assertEquals(0, page.getFirstPage());
        Assertions.assertEquals(pageSize, page.getFinalPage());
    }

    @Test
    void retrievePageForPersistedTaskShouldReturnPageFinalPlusPageSize() {
        int pageSize = 100;
        String taskName = "foo";
        when(pageFetcher.fetchPageFromDb(taskName)).thenReturn(new Page(100,100));
        Page page = pagination.retrievePage(taskName, pageSize);

        Assertions.assertNotEquals(0, page.getFirstPage());
        Assertions.assertEquals(200, page.getFinalPage());
    }
}