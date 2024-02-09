const express = require("express");
const axios = require("axios");
const app = express();
const port = 3000;

app.use(express.static("public"));

app.get("/", (req, res) => {
  res.sendFile(__dirname + "/index.html");
});

//LIST USERS
app.get("/getListUsers", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/users?page=2");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//SINGLE USER
app.get("/getSingleUser", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/users/2");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//SINGLE USER NOT FOUND
app.get("/getSingleUserNotFound", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/users/23");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({});
  }
});

//LIST <RESOURCE>
app.get("/getListResource", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/unknown");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//SINGLE <RESOURCE>
app.get("/getSingleResource", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/unknown/2");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//LIST <RESOURCE> NOT FOUND
app.get("/getSingleResourceNotFound", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/unknown/23");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({});
  }
});

//CREATE
app.post("/createUser", async (req, res) => {
  try {
    const response = await axios.post("https://reqres.in/api/users", {
      name: "morpheus",
      job: "leader",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//UPDATE
app.put("/updateUser", async (req, res) => {
  try {
    const response = await axios.put("https://reqres.in/api/users/2", {
      name: "morpheus",
      job: "zion resident",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//UPDATE
app.patch("/updateUserPatch", async (req, res) => {
  try {
    const response = await axios.patch("https://reqres.in/api/users/2", {
      name: "morpheus",
      job: "zion resident",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//DELETE
app.delete("/deleteUser", async (req, res) => {
  try {
    const response = await axios.delete("https://reqres.in/api/users/2");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

//REGISTER - SUCCESSFUL
app.post("/registerSuccessful", async (req, res) => {
  try {
    const response = await axios.post("https://reqres.in/api/register", {
      email: "eve.holt@reqres.in",
      password: "pistol",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: "Missing password" });
  }
});

//REGISTER - UNSUCCESSFUL
app.post("/registerUnsuccessful", async (req, res) => {
  try {
    const response = await axios.post("https://reqres.in/api/register", {
      email: "sydney@fife",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: "Missing password" });
  }
});

//LOGIN - SUCCESSFUL
app.post("/loginSuccessful", async (req, res) => {
  try {
    const response = await axios.post("https://reqres.in/api/login", {
      email: "eve.holt@reqres.in",
      password: "cityslicka",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: "Missing password" });
  }
});

//LOGIN - UNSUCCESSFUL
app.post("/loginUnsuccessful", async (req, res) => {
  try {
    const response = await axios.post("https://reqres.in/api/login", {
      email: "peter@klaven",
    });
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error: "Missing password" });
  }
});

//DELAYED RESPONSE
app.get("/delayedResponse", async (req, res) => {
  try {
    const response = await axios.get("https://reqres.in/api/users?delay=3");
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ error });
  }
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
