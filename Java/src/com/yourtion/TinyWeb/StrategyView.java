package com.yourtion.TinyWeb;

import java.util.List;
import java.util.Map;

/**
 * Created by Yourtion on 9/5/16.
 */
public class StrategyView implements View {

    private RenderingStrategy viewRenderer;

    public StrategyView(RenderingStrategy viewRenderer) {
        this.viewRenderer = viewRenderer;
    }

    @Override
    public String render(Map<String, List<String>> model) {
        try {
            return viewRenderer.renderView(model);
        } catch (Exception e) {
            throw new RenderingException(e);
        }
    }
}
