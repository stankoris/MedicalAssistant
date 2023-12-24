<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/new_appointment.css">
</head>
<body>

<form action="" method="post" enctype="multipart/form-data">

    <label for="patient_id">Insert patient id</label>
    <select id="patient_id" name="patient_id">
        <#list patients as patient>
            <option value="${patient.getPatient_id()}">
                ${patient.full_name()}
            </option>
        </#list>
    </select>
    <input id="patient_id_input" type="number">

    <label for="doctor_id">Insert doctor id</label>
    <select id="doctor_id" name="doctor_id">
        <#list doctors as doctor>
            <option value="${doctor.getDoctor_id()}">
                ${doctor.full_name()}
            </option>
        </#list>
    </select>
    <input id="doctor_id_input" type="number">

    <input type="datetime-local" name="date_time">

    <button id="btn" type="submit">Press</button>

</form>

<script>
    var patient_id = document.getElementById("patient_id");
    var patient_id_input = document.getElementById("patient_id_input");

    var doctor_id = document.getElementById("doctor_id");
    var doctor_id_input = document.getElementById("doctor_id_input");

    // Dodajte "change" događaj slušaoca za <select> patient_id
    patient_id.addEventListener("change", function() {
        patient_id_input.value = patient_id.value;
    });

    // Dodajte "change" događaj slušaoca za <select> doctor_id
    doctor_id.addEventListener("change", function() {
        doctor_id_input.value = doctor_id.value;
    });
</script>

</body>
</html>
