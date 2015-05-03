package org.wikipedia.templates.find.interwiki.db;

import java.util.Set;

import org.wikipedia.templates.find.interwiki.db.TemplateInterwikiStorage.UnifiedTemplate;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class TemplateInterwikiCandidate {

    Multiset<String> langs = HashMultiset.create();
    UnifiedTemplate template;

    public TemplateInterwikiCandidate(UnifiedTemplate template) {
        super();
        this.template = template;
    }

    public void add(String lang) {
        langs.add(lang);
    }

    public Integer size() {
        return langs.size();
    }

    public Multiset<String> getLangs() {
        return langs;
    }

    public String get(String lang) {
        Set<String> set = this.template.get(lang);
        if (set == null || set.isEmpty()) {
            return null;
        }
        return (String) set.toArray()[0];
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(langs.toString());
        sb.append("\n");
        sb.append(template.toString());
        sb.append("\n");
        return sb.toString();
    }

}