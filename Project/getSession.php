<?php
    function getSessData($PHPSESSID,$data=null){
        $sessPath=session_save_path();
        $barr = (strtoupper(substr(PHP_OS, 0, 3)) === 'WIN')?"\\":"/";
        
        try{
            $filePath = $sessPath.$barr.'sess_'.$PHPSESSID;
            $contents = file_get_contents($filePath);
            session_start();
            session_decode($contents);
            $sess = $_SESSION;
            session_write_close();
            if((isset($data))&&($data!=="")){
                return $sess[$data];
            }
            return json_encode($sess);
        }catch(Exception $e){
            return "erro ao tentar acessar sessão, ela existe mesmo?";
        }
        
    }
    //t76oeidsjndjuhak6ggc3cm8um
    echo getSessData($argv[1],$argv[2]);
   
    