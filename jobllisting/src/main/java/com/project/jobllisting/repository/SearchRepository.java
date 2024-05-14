package com.project.jobllisting.repository;

import com.project.jobllisting.model.Post;

import java.util.List;

public interface SearchRepository {
  List<Post> findByText(String text);
}
