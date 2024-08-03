package com.paccy.ecommerce.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Customer {

   @Id
   private String id;
   private String firstName;
   private String lastName;
   private String email;
   private Address address;
}
