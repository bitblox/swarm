package com.bah.is.micro;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "office", path = "offices")
public interface OfficeResource extends PagingAndSortingRepository<Office, String> {
   
}
