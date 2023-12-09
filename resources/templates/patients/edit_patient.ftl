<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit patient</title>
    <link rel="stylesheet" href="/edit_patient.css">
</head>
<body>
<div class="container">
    <#if updatePatient?has_content>
        <#if updatePatient == "true">
            <div class="success_modal">
                Patient has been updated! 
                <button class="close_button"
                onclick="this.parentElement.remove()">&times;</button>
            </div>
        <#else>
            <div class="error_modal">
                There was an error updating patient!
                <button class="close_button"
                onclick="this.parentElement.remove()">&times;</button>
            </div>
        </#if>
    </#if>
</div>

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
    </script>
</body>
</html>