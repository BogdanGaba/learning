package com.testproject.docstore.config;

import com.testproject.docstore.exceptions.FileUploadException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkingDaysFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {


        if (isWeekend()) {
            throw new FileUploadException("Uploading is not allowed on weekends");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isWeekend() {
        DayOfWeek day = LocalDate.now().getDayOfWeek();
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }
}
