package it.gianni.spring5mvcrest.services;

import it.gianni.spring5mvcrest.api.v1.mapper.VendorMapper;
import it.gianni.spring5mvcrest.api.v1.model.VendorDTO;
import it.gianni.spring5mvcrest.domain.Vendor;
import it.gianni.spring5mvcrest.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class VendorServiceImplTest {

    VendorService vendorService;

    @Mock
    VendorRepository vendorRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        vendorService = new VendorServiceImpl(VendorMapper.INSTANCE, vendorRepository);
    }

    @Test
    public void getAllVendors() throws Exception {

        List<Vendor> vendors = Arrays.asList(new Vendor(), new Vendor(), new Vendor());

        when(vendorRepository.findAll()).thenReturn(vendors);

        List<VendorDTO> vendorDTOs = vendorService.getAllVendors().getVendors();

        assertEquals(3l, vendorDTOs.size());

    }

    @Test
    public void getVendorById() throws Exception {
        final String NAME = "Gianni";
        final Long ID = 1L;

        Vendor vendor = new Vendor();
        vendor.setId(ID);
        vendor.setName(NAME);

        when(vendorRepository.findById(ID)).thenReturn(java.util.Optional.ofNullable(vendor));

        assertEquals(NAME, vendorService.getVendorById(ID).getName());

    }

    @Test
    public void deleteVendorById() throws Exception {
        Long ID = 1L;
        vendorService.deleteVendorById(ID);
        verify(vendorRepository, times(1)).deleteById(anyLong());
    }


}