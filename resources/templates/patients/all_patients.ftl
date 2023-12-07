<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All patients</title>
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
                <th>Address</th>
                <th>Email</th>
                <th>Jmbg</th>
                <th>Phone number</th>
            </tr>
        </thead>
        <tbody>
            <#list patients as patient>
                <tr class="patient">
                    <td>${patient.first_name}</td>
                    <td>${patient.last_name}</td>
                    <td>${patient.date_of_birth}</td>
                    <td>${patient.address}</td>
                    <td>
                         <#if patient.email??>
                                ${patient.email}
                            <#else>
                                N/A
                            </#if>
                    </td>
                    <td>${patient.jmbg}</td>
                    <td>${patient.phone_number}</td>
                    
                </tr>
            </#list>
        </tbody>
    </table>
</div>


    </body>
</html>