/*
 * This file is part of "albirar albirar-template-engine".
 * 
 * "albirar albirar-template-engine" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "albirar albirar-template-engine" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "albirar albirar-template-engine" source code.  If not, see <https://www.gnu.org/licenses/gpl-3.0.html>.
 *
 * Copyright (C) 2020 Octavi Fornés
 */
package cat.albirar.template.engine.service.impl;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import cat.albirar.template.engine.models.TemplateInstanceBean;
import cat.albirar.template.engine.service.ITemplateEngine;

/**
 * The default {@link ITemplateEngine} implementation backed with {@link SpringTemplateEngine}, that supports <a href="https://www.thymeleaf.org/">thymeleaf</a> 
 * {@code markup language} with <a href="https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-view-thymeleaf">spring MVC</a> enhancements.
 * @author Octavi Forn&eacute;s &lt;<a href="mailto:ofornes@albirar.cat">ofornes@albirar.cat</a>&gt;
 * @since 1.0.0
 */
@Service
public class TemplateEngineImpl implements ITemplateEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateEngineImpl.class);
    
    @Autowired
    private SpringResourceTemplateResolver templateResolver;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String renderTemplate(TemplateInstanceBean template) {
        SpringTemplateEngine templateEngine;
        TemplateSpec tspec;
    
        LOGGER.debug("Render template {}", template);
        templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setMessageSource(template.getMessages());
        tspec = new TemplateSpec(template.getTemplate(), Collections.emptySet(), template.getContentType().getTemplateMode()
                , template.getVariables());
        return templateEngine.process(tspec, new TemplateEngineContext(template));
    }
}
