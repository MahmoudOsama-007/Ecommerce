package com.Eccormerce.service.interf;

import com.Eccormerce.dto.AddressDto;
import com.Eccormerce.dto.Response;

public interface AddressService {
    Response saveAndUpdateAddress(AddressDto addressDto);
}
