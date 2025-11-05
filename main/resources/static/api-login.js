document.getElementById("login-form").addEventListener("submit", function (event) {
    event.preventDefault();

    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    fetch("http://localhost:8080/api/users/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ username, password })
    })
    .then(res => {
        if (!res.ok) throw new Error("❌ Invalid credentials!");
        const contentType = res.headers.get("content-type");
        return contentType && contentType.includes("application/json") ? res.json() : res.text();
    })
    .then(data => {
        alert("✅ Login Successful!");
        console.log("Received:", data);

        // Save username safely
        localStorage.setItem("studentName", data.username || data.name || username);

        window.location.href = "start-quiz.html";
    })
    .catch(error => {
        alert(error.message);
        console.error("Login error:", error);
    });
});
