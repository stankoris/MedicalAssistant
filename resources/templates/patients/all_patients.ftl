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
                <th>Full name</th>
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
                    <td> <a class="full_name" href="/technician/edit/${patient.patient_id}">${patient.full_name()}</a></td>
                    <td>${patient.date_of_birth}</td>
                    <td>
                        <#if patient.address??>
                            ${patient.address}
                        <#else>
                            N/A
                        </#if>
                    </td>
                    <td>
                        <#if patient.email??>
                            ${patient.email}
                        <#else>
                            N/A
                        </#if>
                    </td>
                    <td>${patient.jmbg}</td>
                    <td>
                    <#if patient.phone_number??>
                            ${patient.phone_number}
                        <#else>
                            N/A
                        </#if>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>


    </body>
</html>