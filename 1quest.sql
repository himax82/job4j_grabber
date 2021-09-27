select name from person where id != 5;
select company.name from person join company on person.company_id = company.id;