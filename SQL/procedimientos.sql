CREATE OR ALTER PROCEDURE SP_CONSULTA_EQUIPOS (
@VALOR NVARCHAR(255)
)
AS
BEGIN
	SELECT * FROM equipo WHERE (nombre LIKE '%'+ @VALOR +'%' OR director LIKE '%'+ @VALOR +'%' ) AND estado <> 'E';
END

