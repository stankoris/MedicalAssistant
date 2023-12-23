<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/new_appointment.css">
</head>
<body>

    <#if newAppointment?has_content>
        <script>
            <#if newAppointment == "true">
                alert("Patient has been saved successfully!");
                window.location.href = "/technician";
            <#else>
                alert("There was an error saving patient!");
            </#if>
        </script>
    </#if>



<form action="/technician/new_appointment" method="post" enctype="multypart/form-data">

    <label for="patient_id">Izaberi nešto:</label>
    <select id="patient_id" name="patient_id">
            <#list patients as patient>
                <option value="patient_id">
                    ${patient.first_name}
                </option>
            </#list>
    </select>

    <label for="doctor_id">Izaberi nešto:</label>
    <select id="doctor_id" name="doctor_id">
            <#list doctors as doctor>
                <option value="doctor_id">
                    ${doctor.first_name}
                </option>
            </#list>
    </select>

    <input type="datetime-local" id="date_time" name="date_time">

    <button type="submit">Save</button>
</form>
    
</body>
</html>