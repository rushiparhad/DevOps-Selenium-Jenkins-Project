document.getElementById("feedbackForm").addEventListener("submit", function(e) {

    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let mobile = document.getElementById("mobile").value.trim();
    let department = document.getElementById("department").value;
    let feedback = document.getElementById("feedback").value.trim();
    let gender = document.querySelector('input[name="gender"]:checked');

    let error = "";

    // VALIDATIONS
    if (name === "") error += "Name required\n";

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) error += "Invalid Email\n";

    if (!/^\d{10}$/.test(mobile)) error += "Invalid Mobile Number\n";

    if (!gender) error += "Select Gender\n";

    if (department === "") error += "Select Department\n";

    let wordCount = feedback.split(/\s+/).length;
    if (feedback === "" || wordCount < 10)
        error += "Feedback must be at least 10 words\n";

    // IF ERROR → SHOW ERROR
    if (error !== "") {
        e.preventDefault();
        document.getElementById("error").innerText = error;
    } 
    else {
        e.preventDefault(); // stop actual submission (since no backend)

        document.getElementById("error").innerText = "";

        // ✅ SUCCESS POPUP
        alert("Feedback submitted successfully!");

        // OPTIONAL: reset form after success
        document.getElementById("feedbackForm").reset();
    }
});