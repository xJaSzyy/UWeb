async function list_users() {
    const data = await axios.get("https://reqres.in/api/users?page=2");
    console.log(data.data);
  }
  
  async function single_user() {
    const data = await axios.get("https://reqres.in/api/users/2");
    console.log(data.data);
  }
  
  async function single_user_not_found() {
    const data = await axios.get("https://reqres.in/api/users/23");
    console.log(data.data);
  }
  
  async function list_resource() {
    const data = await axios.get("https://reqres.in/api/unknown");
    console.log(data.data);
  }
  
  async function single_resource() {
    const data = await axios.get("https://reqres.in/api/unknown/2");
    console.log(data.data);
  }
  
  async function single_resource_not_found() {
    const data = await axios.get("https://reqres.in/api/unknown/23");
    console.log(data.data);
  }
  
  async function create() {
    const data = await axios.post("https://reqres.in/api/users", {
      name: "morpheus",
      job: "leader",
    });
    console.log(data.data);
  }
  
  async function update() {
    const data = await axios.put("https://reqres.in/api/users/2", {
      name: "morpheus",
      job: "zion resident",
    });
    console.log(data.data);
  }
  
  async function update_patch() {
    const data = await axios.patch("https://reqres.in/api/users/2", {
      name: "morpheus",
      job: "zion resident",
    });
    console.log(data.data);
  }
  
  async function delete_user() {
    const data = await axios.delete("https://reqres.in/api/users/2");
    console.log(data.data);
  }
  
  async function register_successful() {
    const data = await axios.post("https://reqres.in/api/register", {
      email: "eve.holt@reqres.in",
      password: "pistol",
    });
    console.log(data.data);
  }
  
  async function register_unsuccessful() {
    try {
      const data = await axios.post("https://reqres.in/api/register", {
        email: "sydney@fife",
      });
      console.log(data.data);
    } catch {
      console.log("Missing password");
    }
  }
  
  async function login_successful() {
    const data = await axios.post("https://reqres.in/api/login", {
      email: "eve.holt@reqres.in",
      password: "cityslicka",
    });
    console.log(data.data);
  }
  
  async function login_unsuccessful() {
    try {
      const data = await axios.post("https://reqres.in/api/login", {
        email: "peter@klaven",
      });
      console.log(data.data);
    } catch {
      console.log("Missing password");
    }
  }
  
  async function delayed_repsonse() {
    const data = await axios.get("https://reqres.in/api/users?delay=3");
    console.log(data.data);
  }