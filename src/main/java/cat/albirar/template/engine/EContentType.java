/*
 * This file is part of "albirar-template-engine".
 * 
 * "albirar-template-engine" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "albirar-template-engine" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "albirar-template-engine" source code.  If not, see <https://www.gnu.org/licenses/gpl-3.0.html>.
 *
 * Copyright (C) 2020 Octavi Fornés
 */
package cat.albirar.template.engine;

import org.thymeleaf.templatemode.TemplateMode;

/**
 * Content type of resulting template.
 * @author Octavi Forn&eacute;s &lt;<a href="mailto:ofornes@albirar.cat">ofornes@albirar.cat</a>&gt;
 * @since 1.0.0
 */
public enum EContentType {
    TEXT_PLAIN,
    HTML
    ;
    /**
     * Gets the media type for this content type.
     * @return The media type
     */
    public String getMediaType() {
        if(this == HTML) {
            return "text/html";
        }
        return "text/plain";
    }
    /**
     * Get the {@link TemplateMode} for this content type.
     * @return the {@link TemplateMode} related to this element.
     */
    public TemplateMode getTemplateMode() {
        if(this == HTML) {
            return TemplateMode.HTML;
        }
        return TemplateMode.TEXT;
    }
}
