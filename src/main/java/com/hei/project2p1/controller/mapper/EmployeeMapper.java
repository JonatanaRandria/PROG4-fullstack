package com.hei.project2p1.controller.mapper;

import com.hei.project2p1.controller.model.EmployeeModel;
import com.hei.project2p1.model.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Component
@AllArgsConstructor
public class EmployeeMapper {

    public EmployeeEntity toDomain(EmployeeModel employee){
        EmployeeEntity domainEmployeeEntity = EmployeeEntity.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .birthDate(employee.getBirthDate())
                .build();
        try {
            MultipartFile imageFile = employee.getProfileImage();
            if (imageFile != null && !imageFile.isEmpty()) {
                // Get the image file content as a byte array
                byte[] imageBytes = imageFile.getBytes();

                // Convert the byte array to a Base64 string
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                domainEmployeeEntity.setProfileImage(base64Image);
            }
            return domainEmployeeEntity;
        }
        catch (Exception e){
            throw new RuntimeException("Bad Request");
        }
    }

}