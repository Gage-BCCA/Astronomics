package com.failedalgorithm.astronomics.users.auth;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class ApiKeyFilter implements Filter
{

    @Autowired
    ApiKeyRepository apiKeyRepository;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String apiKey = httpRequest.getHeader("X-API-KEY"); // Read API key from headers

        if (httpRequest.getServletPath().equals("/accounts/register"))
        {
            chain.doFilter(httpRequest, response);
        }
        else
        {
            apiKeyRepository.findByKey(apiKey).ifPresentOrElse(
                    apiKeyEntity ->
                    {
                        httpRequest.setAttribute("userId", apiKeyEntity.getUser().getId());
                        try
                        {
                            chain.doFilter(httpRequest, response);
                        }
                        catch (IOException | ServletException e)
                        {
                            throw new RuntimeException(e);
                        }
                    },
                    () ->
                    {
                        try
                        {
                            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                    "Invalid API Key");
                        }
                        catch (IOException e)
                        {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }

    }
}
