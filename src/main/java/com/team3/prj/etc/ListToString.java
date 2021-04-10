package com.team3.prj.etc;

import java.util.List;

public class ListToString<T> {

    public void print(List<T> lst) {
        if(lst != null) {
            System.out.println(toString(lst, "\n"));
            System.out.println("총 " + lst.size() + " 건의 자료가 있습니다.");
        }
        else {
            System.out.println("null입니다.");
        }
    }

    public String toString(List<T> lst, String postFix) {
        StringBuilder sb = new StringBuilder();

        if (lst != null) {
            for (T item : lst) {
                sb.append(item + postFix);
            }
        }

        return sb.toString();
    }

}
