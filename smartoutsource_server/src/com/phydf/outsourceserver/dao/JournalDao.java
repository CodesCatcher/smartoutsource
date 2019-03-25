package com.phydf.outsourceserver.dao;

import com.phydf.outsourceserver.bean.Journal;

import java.util.List;

public interface JournalDao {

    List<Journal> searchLikeJournal(String value);

}
