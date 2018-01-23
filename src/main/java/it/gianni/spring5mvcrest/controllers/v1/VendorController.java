package it.gianni.spring5mvcrest.controllers.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.gianni.spring5mvcrest.api.v1.model.VendorDTO;
import it.gianni.spring5mvcrest.api.v1.model.VendorListDTO;
import it.gianni.spring5mvcrest.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "This is my Vendors Controller")
@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a list of Vendors")
    public VendorListDTO getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns a Vendor with the given id")
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletes a Vendor with the given id")
    public void deleteVendorById(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Creates a Vendor")
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Updates a Vendor with the given id")
    public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.saveVendorByDTO(id, vendorDTO);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Patches a Vendor with the given id")
    public VendorDTO patchVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
        return vendorService.patchVendor(id, vendorDTO);
    }
}
