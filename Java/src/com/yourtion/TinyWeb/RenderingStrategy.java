package com.yourtion.TinyWeb;

import java.util.List;
import java.util.Map;

/**
 * Created by Yourtion on 9/5/16.
 */
public interface RenderingStrategy {

    public String renderView(Map<String, List<String>> model);

}
