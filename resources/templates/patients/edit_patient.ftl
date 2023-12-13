<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit patient</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/edit_patient.css">
</head>
<body>

    <#if updatePatient?has_content>
        <script>
            <#if updatePatient == "true">
                alert("Patient has been updated!");
                window.location.href("/technician/edit/${patient.patient_id}")
            <#else>
                alert("There was an error updating patient!");
            </#if>
        </script>
    </#if>

<header>
    <h1><a href="/technician">MedicalAssistant</a></h1>

    <div class="container">
        <button id="showOptionsBtn" ><i class="fa-solid fa-bars"></i></button>
        <div class="options-container" id="optionsContainer">
            <a href="/technician/all_patients">All patients</a>
            <a href="/technician/find_patients">Find patient</a>
            <a href="/technician/new_patient">New patient</a>
        </div>
    </div>
</header>

<form id="new_patient_form" action="/technician/edit/${patient.patient_id}" method="post" enctype="multipart/form-data">
    <div>
        <label>First name</label>
        <input type="text" name="first_name" value="${patient.first_name}" />
    </div>
    <div>
        <label>Last name</label>
        <input type="text" name="last_name" value="${patient.last_name}">
    </div>
    <div>
        <label>Date of birth</label>
        <input type="date" name="date_of_birth" min="1900-01-01" max="2023-11-27" value='${patient.date_of_birth!""}'>
    </div>
    <div>
        <label>Address</label>
        <input type="text" name="address" value='${patient.address!""}'>
    </div>
    <div>
        <label>E-mail</label>
        <input type="email" name="email" value='${patient.email!""}'>
    </div>
    <div>
        <label>Jmbg</label>
        <input type="text" name="jmbg" oninput="validateNumber(this)" maxlength="13" value="${patient.jmbg}">
    </div>
    <div>
        <label>Phone number</label>
        <input type="number" name="phone_number" value='${patient.date_of_birth!""}'>
    </div>
        <button type="submit">Update</button>
    </div>
</form>

<script>
    const new_patient_form = document.getElementById("new_patient_form")
    new_patient_form.onsubmit = () => {
        const html_content = editor.getContents(true);
    }

        document.getElementById('showOptionsBtn').addEventListener('click', function() {
    var optionsContainer = document.getElementById('optionsContainer');

    if (optionsContainer.classList.contains('show')) {
        optionsContainer.classList.remove('show');
    } else {
        optionsContainer.classList.add('show');
    }
});
</script>

</body>
</html>