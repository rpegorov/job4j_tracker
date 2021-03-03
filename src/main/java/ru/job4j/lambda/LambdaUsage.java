package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 4", 100),
                new Attachment("image 1", 34),
                new Attachment("image 8", 13)
        );

        Comparator<Attachment> cmpText = (left, right) -> {
            System.out.println("compare to:" + left.getName() + " : " + right.getName());
            return right.getName().compareTo(left.getName());
        };

        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare: " + left.getSize() + " : " + right.getSize());
            return  right.getSize() - left.getSize();
        };
        attachments.sort(cmpText);
        System.out.println(attachments);
        attachments.sort(cmpDescSize);
        System.out.println(attachments);
    }
}
