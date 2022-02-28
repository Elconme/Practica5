@RestController
public class MainController {

    @PostMapping(
    path="/login",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String> login(
                @Valid @RequestBody LoginCredential loginParam,
                BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.BAD_REQUEST);
            }

            if ((loginParam.user().equals("DEMO")) &&
                (loginParam.password().equals("DEMO"))) {
                return new ResponseEntity<>("{\"result\" : \"OK\"}", HttpStatus.OK);
            }
            return new ResponseEntity<>("{\"result\" : \"KO\"}", HttpStatus.UNAUTHORIZED);
        }

}