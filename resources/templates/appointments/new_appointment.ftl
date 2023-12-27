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

    <label for="patient_id">Pick patient</label>
    <select id="patient_id" name="patient_id">
        <#list patients as patient>
            <option value="${patient.getPatient_id()}">
                ${patient.full_name()}
            </option>
        </#list>
    </select>
    
    
    <input type="date" name="date">
    <input type="time" name="time" step="3600" value="08:00">

    <button id="btn" type="submit">Press</button>

</form>

<script>

    let patient_id = document.getElementById("patient_id");

    document.getElementById("btn").addEventListener("click", function(event) {
        event.preventDefault(); 
        let data = {
            patient_id: patient_id.value,
            date: document.querySelector('input[type="date"]').value,
            time: document.querySelector('input[type="time"]').value,
        };

        fetch('/technician/new_appointment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => response.json())
        .then(data => {
           console.log(data.value);
        })
        .catch(error => {
            console.log(data.value);
            console.log("Greska", error);
        });
    });


</script>

</body>
</html>
