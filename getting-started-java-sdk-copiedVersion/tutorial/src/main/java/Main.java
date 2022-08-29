// TODO: Authorization Step 1: Launch Smartcar authentication dialog
String mode = "test";

AuthClient client = new AuthClient.Builder().mode(mode).build();

get("/login", (req, res) -> {
    // TODO: Authorization Step 2: Launch Smartcar authentication dialog
    String[] scope = {"read_odometer"};
    String link = client.authUrlBuilder(scope).build();
    res.redirect(link);
    return null;
});

get("/exchange", (req, res) -> {
    // TODO: Authorization Step 3: Handle Smartcar response
    String code = req.queryMap("code").value();

    System.out.println(code);

    return "";
});

