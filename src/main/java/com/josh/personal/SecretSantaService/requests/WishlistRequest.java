package com.josh.personal.SecretSantaService.requests;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistRequest {
    private Integer id;
    private Integer year;
}
