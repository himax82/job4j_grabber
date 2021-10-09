package ood.ocp;

import java.util.Comparator;
import java.util.List;

public class Collection {

    public List<String> sort(List<String> list) {
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
