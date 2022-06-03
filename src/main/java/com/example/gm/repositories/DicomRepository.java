package com.example.gm.repositories;

import com.example.gm.models.Dicom;
import org.springframework.data.repository.CrudRepository;

public interface DicomRepository extends CrudRepository<Dicom, Long> {
}
