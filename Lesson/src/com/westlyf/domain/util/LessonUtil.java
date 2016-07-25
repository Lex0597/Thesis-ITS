package com.westlyf.domain.util;

import com.westlyf.domain.lesson.Lesson;
import com.westlyf.domain.lesson.Level;

import java.util.ArrayList;

/**
 * Created by robertoguazon on 08/06/2016.
 */
public class LessonUtil {

    //use sql to get lessons per tag
    public static ArrayList<Lesson> findLessonsExactly(Level level, ArrayList<Lesson> lessons) {
        String levelTagsString = level.getTagsString();
        ArrayList<Lesson> matchingLessons = new ArrayList<>();

        for (Lesson l : lessons) {
            if (levelTagsString == null || l.getTagsString() == null) return null;
            if (levelTagsString.equals(l.getTagsString())) {
                matchingLessons.add(l);
            }
        }

        return matchingLessons;
    }

    public static ArrayList<Lesson> findLessons(Level level, ArrayList<Lesson> lessons) {
        ArrayList<String> levelTags = level.getTags();
        ArrayList<Lesson> matchingLessons = new ArrayList<>();

        for (Lesson l : lessons) {
            if (level.getTagsString() == null || l.getTagsString() == null) return null;

            ArrayList<String> lTags = l.getTags();
            for (String tag : lTags) {
                if (levelTags.contains(tag)) {
                    matchingLessons.add(l);
                }
            }

        }

        return matchingLessons;
    }

}
