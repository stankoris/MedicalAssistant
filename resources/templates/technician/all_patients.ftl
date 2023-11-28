<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Patient</title>
    <link rel="stylesheet" href="/allpatients.css">
</head>
    <body>

    
        <div class="container">
    <table>
        <thead>
            <tr>
                <th>First name</th>
                <th>Last name</th>
                <th>Date of birth</th>
                <th>Email</th>
                <th>Jmbg</th>
            </tr>
        </thead>
        <tbody>
            <#list patients as patient>
                <tr class="patient">
                    <td>${patient.first_name}</td>
                    <td>${patient.last_name}</td>
                    <td>${patient.date_of_birth}</td>
                    <td>${patient.email}</td>
                    <td>${patient.jmbg}</td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>


    </body>
</html>