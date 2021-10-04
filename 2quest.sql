select company.name, count(*) as c from person join company on (company.id = person.company_id)
group by company.name order by c desc limit 1;
WITH g AS (select company.name, count(*) as c from company join person
		  on (company.id = person.company_id) group by company.name)
SELECT * FROM g WHERE g.c = (SELECT MAX(g.c) FROM g);